import React,{ useState,useEffect } from "react";
import { get as getEndpoint } from "zero-element/lib/utils/request/endpoint";
import { getToken } from "zero-element/lib/utils/request/token";
import ZEle from "zero-element/lib/ZEle";
import { tableConfig } from "./config/tableConfig";
export default function Table(props){
    const [Config,setConfig] = useState()
    // console.log(GetAPI());
    const listAPI = getEndpoint()+GetAPI()
    const token = getToken()
    useEffect(() => {
        
        fetch(listAPI,{
            headers:{
                "Content-Type":"application/json;charset=UTF-8",
                "Authorization":`Bearer ${token}`
            }
        })
        .then(res=>{
            let json=res.json();
            // console.log(json);
            Promise.resolve(json).then((val)=>{
                // console.log(val.data.avatar)
                if(val.code===200){
                    // console.log(val.data.records);
                    setConfig(val.data.records)
                }else{
                  console.error("错误")
                }
            })
    
        })
        .catch(err=>{
            console.log(err);
        })
    },[])

    return <ZEle namespace="dataReport" config={Config}></ZEle>
}

function GetAPI(){
    let Url = window.location.href
    let newUrl=Url.split("?")
    // console.log(newUrl[1]);
    let id=newUrl[1].replace(/id=/,"")
    // console.log(newUrl[1]);
    // console.log(id);
    let HasIdAPI = tableConfig.API.getListAPI
    let ListAPI = HasIdAPI.replace(/\(id\)/,id)
    return ListAPI
}