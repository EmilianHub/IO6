import React from 'react';
import {NavBarData} from "./NavBarData";
import {Link} from "react-router-dom";
import "./NavBar.css"

const Navbar = () => {
    return (
        <nav className={"NavBarItems"}>
            <h1 className={"Logo"}>
                Minutówka
            </h1>
            <ul className={"items-nav"}>
                    {NavBarData.map((key, value) => {
                        return (
                        <li key={value}>
                            <Link to= {key.link} className={"nav-text"}>
                            {key.img} {key.name}
                            </Link>
                        </li>
                        );
                    })
                    }
            </ul>
        </nav>
    );
};

export default Navbar;