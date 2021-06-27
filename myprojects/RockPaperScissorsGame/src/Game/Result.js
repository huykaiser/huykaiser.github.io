import React, { Component } from 'react'
import {connect} from 'react-redux'

class Result extends Component {
    render() {
        return (
            <div>
                <div className="display-4 text-warning">{this.props.result}</div>
                <div className="display-4 text-success">
                    Win: <span>{this.props.win}</span>
                </div>
                <div className="display-4 text-success">
                    The number of games: <span>{this.props.numberOfGames}</span>
                </div>
            </div>
        )
    }
}

const mapStateToProps = state =>{
    return{
        result: state.GameRPSReducer.result,
        win: state.GameRPSReducer.win,
        numberOfGames: state.GameRPSReducer.numberOfGames
    }
}

export default connect(mapStateToProps)(Result)
