import React, {useState} from "react";
import axios from "axios";
import "./ProfilForm.css";
export default function ProfilForm(){

    return(

        <div className={"profilCont"}>
            <div className={"profilH1"}> Profil użytkownika </div>
    <div className={"profilTable"}>
    <tr>
        <th className={"cth"}>Nr pożyczki </th>
        <th className={"cth"}> Data zaciągnięcia </th>
        <th className={"cth"}>Kwota pożyczki </th>
        <th className={"cth"}>Data zakończenia </th>
        <th className={"cth"}> Wysokość raty</th>
        <th className={"cth"}> Status pożyczki </th>
        <th className={"cth"}> Spłać ratę</th>
    </tr>
        <tr>

            <td className={"ctd"}> 1.</td>
            <td className={"ctd"}> 2022-15-11</td>
            <td className={"ctd"}> 1500 PLN</td>
            <td className={"ctd"}> 2022-15-12</td>
            <td className={"ctd"}> 1500 PLN</td>
            <td className={"ctd"}> Aktywna</td>
            <td className={"ctd"}> <button className={"td-butn"}>Spłać</button></td>


        </tr>
        <button className={"profilBtn"}>Edytuj swoje dane</button>
        <button className={"profilBtn"}>Strona główna</button>
        </div>

        </div>
    )
}