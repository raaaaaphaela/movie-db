import React, {useEffect, useState} from 'react';
import './App.css';
import axios from "axios";
import NewMovie from "./NewMovie";
import MovieCard from "./MovieCard";

export type Movie = {
    "id"?: number;
    "title": string;
    "imageUrl": string;
    "year": number;
}

function App() {

    const [movies, setMovies] = useState<Movie[]>([]);

    useEffect(() => {
        (async () => {
            const response = await axios.get("/api/movies");
            setMovies(response.data);
        })();
    }, []);

    return (
        <div className="movie-db">
            <div className={"header"}>
                <h1>Movie DB</h1>
            </div>
            <input className={"input"} type="text" placeholder={"Film suchen"}/>
            <div className={"gallery"}>
                {movies.length === 0 ? <p>Keine Filme vorhanden...</p> : movies.map(movie => {
                    return (<MovieCard key={movie.id} imageUrl={movie.imageUrl} title={movie.title} year={movie.year}/>)
                })}
            </div>
            <NewMovie/>
        </div>
    );
}

export default App;
