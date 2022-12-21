import React from 'react';
import './App.css';
import Homepage from "./pages/Homepage";
import {BrowserRouter, Route, Routes} from "react-router-dom";


export type Movie = {
    "id": number;
    "title": string;
    "imageUrl": string;
    "year": number;
}

function App() {

    return (
        <>
            <BrowserRouter>
                <Routes>
                    <Route path={"/"} element={<Homepage/>}/>
                </Routes>
            </BrowserRouter>
        </>
    );
}

export default App;
