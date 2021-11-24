using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using MySql.Data.MySqlClient;

namespace SystemLogin
{
    public partial class Form1 : Form
    {
        private MySqlConnection conn;
        private string server;
        private string database;
        private string uid;
        private string password;

        public Form1()
        {
            server = "localhost";
            database = "tut";
            uid = "root";
            password = "123456789";

            string connString = $"SERVER={server};DATABASE={database};UID={uid};PASSWORD={password};";

            conn = new MySqlConnection(connString);

            InitializeComponent();
        }

        private void btnRegister_Click(object sender, EventArgs e)
        {
            string user = tbUser.Text;
            string pass = tbPass.Text;

            if (Register(user, pass))
            {
                MessageBox.Show($"User {user} has been created!");
            }
            else
            {
                MessageBox.Show($"User {user} has not been created!");
            }
        }

        public bool Register(string user, string pass)
        {
            string query = $"INSERT INTO users (username,password) VALUES ('{user}','{pass}');";

            try
            {
                if (OpenConnection())
                {
                    MySqlCommand cmd = new MySqlCommand(query, conn);

                    try
                    {
                        cmd.ExecuteNonQuery();
                        //MySqlDataReader reader = cmd.ExecuteReader();
                        return true;
                    }
                    catch (Exception ex)
                    {
                        MessageBox.Show(ex.Message);
                        return false;
                    }
                }
                else
                {
                    conn.Close();
                    return false;
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
                conn.Close();
                return false;
            }
        }

        public bool IsLogin(string user, string pass)
        {
            string query = $"SELECT * FROM users WHERE username='{user}' AND password='{pass}'";

            try
            {
                if (OpenConnection())
                {
                    MySqlCommand cmd = new MySqlCommand(query, conn);
                    MySqlDataReader reader = cmd.ExecuteReader();

                    if (reader.Read())
                    {
                        reader.Close();
                        conn.Close();
                        return true;
                    }
                    else
                    {
                        reader.Close();
                        conn.Close();
                        return false;
                    }
                }
                else
                {
                    conn.Close();
                    return false;
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show(ex.Message);
                conn.Close();
                return false;
            }

        }

        private bool OpenConnection()
        {
            try
            {
                conn.Open();
                return true;
            }
            catch (MySqlException ex)
            {
                switch (ex.Number)
                {
                    case 0:
                        MessageBox.Show("Connection to server failed!!!! plzz");
                        break;
                    case 1045:
                        MessageBox.Show("Server username or password is incorrect!");
                        break;
                }
                return false;
            }
        }

        private void btnLogin_Click(object sender, EventArgs e)
        {
            string user = tbUser.Text;
            string pass = tbPass.Text;

            if (IsLogin(user, pass))
            {
                MessageBox.Show($"Welcome {user}!!!");
            }
            else
            {
                MessageBox.Show($"{user} does not exist or password is incorrect!");
            }
        }
    }
}
