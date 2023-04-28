import ProfessorsBlocks from "./professors/ProfessorsBlocks";
import "./main-page.css"
import ProfessorsRedactor from "./professors/ProfessorsRedactor";
import UrlsFetch from "../../UrlsFetch";
import {useEffect, useState} from "react";
function MainPage() {
    let [professors, setProfessors] = useState([])

    useEffect(() => {
        getProfessors()
    },[])

    return <div className={'main-page'}>
        <ProfessorsBlocks professors={professors}/>
        <hr/>
        <ProfessorsRedactor getProfessorsEvent={getProfessors}/>
        <hr/>
    </div>

    async function getProfessors(){
        await fetch(UrlsFetch.GET_PROFESSORS)
            .then(res => res.json())
            .then((result => {
                setProfessors(result);
            }))

    }
}

export default MainPage;

