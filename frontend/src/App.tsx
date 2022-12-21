import React from 'react';
import './App.css';
import Homepage from "./pages/Homepage";
import {BrowserRouter, Link, Route, Routes} from "react-router-dom";


export type Movie = {
    "id": number;
    "title": string;
    "imageUrl": string;
    "year": number;
    "favorite": boolean;
}

function App() {

    return (
        <>
            <BrowserRouter>
                <div className="movie-db">
                    <div className={"header"}>
                        <h1>Movie DB</h1>
                    </div>
                    <nav>
                        <ul>
                            <li><Link to={"/"}>Home</Link></li>
                            <li><Link to={"/favorites"}>Favoriten</Link></li>
                        </ul>
                    </nav>
                </div>
                <Routes>
                    <Route path={"/"} element={<Homepage/>}/>
                    <Route path={"/favorites"} element={<Homepage/>}/>
                </Routes>
            </BrowserRouter>
        </>
    );
}

export default App;
