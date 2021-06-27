import React, { Component } from 'react'
import './GameRPC.css'
import Computer from './Computer'
import Player from './Player'
import Result from './Result'
import { connect } from 'react-redux'

class GameRPC extends Component {
    render() {
        return (
            <div className="gameRPS">
                <div className="row text-align-center mt-5">
                    <div className="col-3 mt-5">
                        <Player/>
                    </div>

                    <div className="col-6 mt-5">
                        <Result/>

                        <button onClick={()=>{this.props.playGame()}} className="btn btn-success p-2 m-5 display-4">
                            Play Game
                        </button> 
                    </div>

                    <div className="col-3 mt-5">
                            <Computer/>
                        </div>
                </div>
            </div>
        )
    }
}

const mapDispatchToProps = dispatch =>{
    return {
        playGame: () =>{
            let count = 0; 

            let randomComputerItem = setInterval(() => {
                dispatch({
                    type: 'RAN_DOM'
                })
                count++;

                if(count > 10){
                    //stop setInterval
                    clearInterval(randomComputerItem)

                    dispatch({
                        type:'END_GAME',
                    })
                }
            }, 100)
        }
    }
}

export default connect(null, mapDispatchToProps)(GameRPC)
