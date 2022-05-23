import {useState} from 'react';
import Auth from './auth';
import BaseInfo from './baseInfo';
import Security from './security';
import './index.less'

export default function (){
    const [element,setElement]=useState(<BaseInfo/>);


    const [textList,setTextList] = useState([
        "用户管理","实名认证","账号安全"
    ])

    let children = document.getElementsByClassName("UserPage_LeftNav_Children")


    function GetListClick(key){
        // console.log(key)
        children[key].classList.add('Click')
        switch(key){
            case 0:setElement(<BaseInfo/>);break;
            case 1:setElement(<Auth/>);break;
            case 2:setElement(<Security/>);break;
        }
        return element;
    }
    
    function ClearAllClick(){
        for(var i=0;i<textList.length;i++){
            console.log(i)
            children[i].classList.remove('Click')
        }
    }

    return<div className="UserPage_Pages">
        <div className="UserPage_LeftNav">
            {
                textList.map((text,index)=>{
                    return <a key={index} className="UserPage_LeftNav_Children" onClick={(e)=>{ClearAllClick();GetListClick(index);}}>{text}</a>
                })
            }
        </div>
        <div className="UserPage_Content">
            {element?element:null}
        </div>
    </div>   
}