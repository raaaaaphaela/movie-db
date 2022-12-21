import MovieCard from "../components/MovieCard/MovieCard";
import NewMovie from "../components/NewMovie/NewMovie";
import React, {useEffect, useState} from "react";
import axios from "axios";
import {Movie} from "../App";

export default function Homepage() {

    const [movies, setMovies] = useState<Movie[]>([]);
    const [filter, setFilter] = useState<string>("");

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
            <input className={"input"}
                   type="text"
                   name="filter"
                   placeholder={"Film suchen"}
                   onChange={(e) => setFilter(e.target.value)}/>
            <div className={"gallery"}>
                {movies.length === 0 ?
                    <p>Keine Filme vorhanden...</p> :
                    movies.filter(movie => movie.title.toLowerCase().includes(filter.toLowerCase()))
                        .map(movie => {
                            return (<MovieCard key={movie.id} movie={movie}/>)
                        })}
            </div>
            <NewMovie/>
        </div>
    )
}