import React from 'react';
import './App.css';
import Homepage from "./pages/Homepage";
import {BrowserRouter, Link, Route, Routes} from "react-router-dom";
import Favorites from "./pages/Favorites";

function App() {

    return (
        <>
            <BrowserRouter>
                <div className="movie-db">
                    <div className={"header"}>
                        <h1>Movie DB</h1>
                        <nav id={"navigation"}>
                            <ul>
                                <li><Link to={"/"}>Home</Link></li>
                                <li><Link to={"/favorites"}>Favoriten</Link></li>
                            </ul>
                        </nav>
                    </div>
                </div>
                <Routes>
                    <Route path={"/"} element={<Homepage/>}/>
                    <Route path={"/favorites"} element={<Favorites/>}/>
                </Routes>
            </BrowserRouter>
        </>
    );
}

export default App;
