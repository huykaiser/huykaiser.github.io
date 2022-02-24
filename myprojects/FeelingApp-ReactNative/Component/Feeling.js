import { Text, View, Image, StyleSheet, TouchableOpacity } from 'react-native';
import React, { Component } from 'react';

export default class Feeling extends Component {
    state = {
        pic: require('../images/emoji/love.png'),
    };

    onPressEmoji = (icon) => {
        switch(icon){
            case 'angry': this.setState({pic: require('../images/emoji/angry.png')}); break;
            case 'care': this.setState({pic: require('../images/emoji/care.png')}); break;
            case 'love': this.setState({pic: require('../images/emoji/love.png')}); break;
            case 'sad': this.setState({pic: require('../images/emoji/sad.png')}); break;
            case 'like': this.setState({pic: require('../images/emoji/like.png')}); break;
        }    
    }

    render() {
        return (
            <View style={styles.container}>
                <Text style={styles.txt}>How do you feel today?</Text>

                {/* display icon  */}
                <Image source={this.state.pic} style={styles.imgStyle} />

                {/* icon items */}
                <View style={styles.imgRow}>
                    {/* angry icon */}
                    <TouchableOpacity onPress={()=>{this.onPressEmoji('angry')}}>
                        <Image source={require('../images/emoji/angry.png')} style={styles.imgItem} />
                    </TouchableOpacity>

                    {/* care icon */}
                    <TouchableOpacity onPress={()=>{this.onPressEmoji('care')}}>
                        <Image source={require('../images/emoji/care.png')} style={styles.imgItem} />
                    </TouchableOpacity>

                    {/* love icon  */}
                    <TouchableOpacity onPress={()=>{this.onPressEmoji('love')}}>
                        <Image source={require('../images/emoji/love.png')} style={styles.imgItem} />
                    </TouchableOpacity>

                    {/* sad icon */}
                    <TouchableOpacity onPress={()=>{this.onPressEmoji('sad')}}>
                        <Image source={require('../images/emoji/sad.png')} style={styles.imgItem} />
                    </TouchableOpacity>

                    {/* like icon */}
                    <TouchableOpacity onPress={()=>{this.onPressEmoji('like')}}>
                        <Image source={require('../images/emoji/like.png')} style={styles.imgItem} />
                    </TouchableOpacity>
                </View>
            </View>
        );
    }
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
    },
    txt: {
        fontSize: 25,
        marginVertical: 15,
    },
    imgStyle: {
        width: 130,
        height: 130,
    },
    imgItem: {
        width: 50,
        height: 50,
        marginHorizontal: 10,
    },
    imgRow: {
        flexDirection: 'row',
        marginVertical: 20,
    }
});

