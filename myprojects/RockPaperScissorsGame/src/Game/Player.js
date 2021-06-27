import React, { Component } from 'react'
import {connect} from 'react-redux'

class Player extends Component {
    render() {
        return (
            <div className="text-center playerGame">
                <div className="theThink">
                    <img className="mt-3" style={{width:100, height:100,transform:'rotate(180deg)'}} src={this.props.items.find(item=>item.bet === true).pic} alt={this.props.items.find(item=>item.bet === true).pic}/>                
                </div>

                <div className="speech-bubble"></div>
                
                <img style={{width:200, height:200}} src="./img/gamePictures/player.png" alt="player"/>

                {/* item options */}
                <div className="row">
                    {this.props.items.map((item,index) => {
                        let border = {};

                        if(item.bet){
                            border={border:'3px solid orange'};
                        }

                        return <div className="col-4">
                            <button onClick={() => {
                                this.props.bet(item.itemName);
                            }} style={border} className="btnItem">
                                <img width={50} height={50} src={item.pic} alt={item.itemName}/>
                            </button>
                        </div>
                    })}
                </div>
            </div>
        )
    }
}

// connect to state in reducer store 
const mapStateToProps = state => {
    return {
        items: state.GameRPSReducer.items
    }
}

const mapDispatchToProps = (dispatch) => {
    return{
        bet: (betName) => {
            dispatch({
                type: 'CHOOSE_ITEM',
                betName
            })
        }
    }
}

export default connect(mapStateToProps,mapDispatchToProps)(Player)
