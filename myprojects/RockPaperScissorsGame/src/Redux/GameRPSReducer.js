const stateDefault = {
    items:[
        {itemName:'scissor', pic:'./img/gamePictures/scissor.png',bet:false},
        {itemName:'rock', pic:'./img/gamePictures/rock.png',bet:true},
        {itemName:'paper', pic:'./img/gamePictures/paper.png',bet:false},
    ],
    result: "I'm iron man, I win and I love you 3000!!!",
    win:0,
    numberOfGames:0,
    computer:{itemName:'paper', pic:'./img/gamePictures/rock.png'},
}

const GameRPSReducer = (state = stateDefault, action) => {
    switch(action.type){
        case 'CHOOSE_ITEM':{
            let itemsUpdate = [...state.items]; 

            itemsUpdate = itemsUpdate.map((item,index) => {
                if(item.itemName === action.betName){ 
                    return {...item,bet:true}
                }

                return {...item,bet:false}
            })

            state.items = itemsUpdate;
            return {...state};

        }

        case 'RAN_DOM':{
            let randomNumber = Math.floor(Math.random()*3);
            let itemBetRandom = state.items[randomNumber];

            state.computer = itemBetRandom;
            return {...state};
        }

        case 'END_GAME':
            let player = state.items.find(item => item.bet===true);
            let computer = state.computer;

            switch(player.itemName){
                case 'scissor':
                    if(computer.itemName === 'scissor'){
                        state.result = "draw!!!";
                    }else if(computer.itemName === 'rock'){
                        state.result = "lose!!!";
                    }else{
                        state.win += 1;
                        state.result = "I'm iron man, I win and I love you 3000!!!";
                    }
                    break;

                case 'rock':
                    if(computer.itemName === 'rock'){
                        state.result = "draw!!!";
                    }else if(computer.itemName === 'paper'){
                        state.result = "lose!!!";
                    }else{
                        state.win += 1;
                        state.result = "I'm iron man, I win and I love you 3000!!!";
                    }
                    break;                       

                case 'paper':
                    if(computer.itemName === 'paper'){
                        state.result = "draw!!!";
                    }else if(computer.itemName === 'scissor'){
                        state.result = "lose!!!";
                    }else{
                        state.win += 1;
                        state.result = "I'm iron man, I win and I love you 3000!!!";
                    }                        
                    break;     

                default: state.result = "I'm iron man, I win and I love you 3000!!!";
            }
        
        state.numberOfGames += 1;
        return {...state};

        default: return {...state}
    }
}

export default GameRPSReducer;