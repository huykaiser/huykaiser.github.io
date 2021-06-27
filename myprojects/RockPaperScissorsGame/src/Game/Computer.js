import React, { Component } from 'react'
import {connect} from 'react-redux'

class Computer extends Component {
    render() {
    
        return (
            <div className="text-center playerGame">
                <div className="theThink" style={{position:'relative'}}>
                    <img style={{transform:'rotate(120deg)',position:'absolute',left:'30%',animation:`randomItem${Date.now()} 0.5s`}} width={100} height={100} className="mt-3" src={this.props.computer.pic} alt={this.props.computer.pic}/>
                </div>

                <div className="speech-bubble"></div>
                <img style={{width:200,height:200}} src="./img/gamePictures/playerComputer.png" alt="playerComputer"/>
            </div>
        )
    }
}

const mapStateToProps = state => {
    return {
        computer: state.GameRPSReducer.computer
    }
}

export default connect(mapStateToProps)(Computer)
