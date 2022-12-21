import {Movie} from "../App";
import MovieCard from "../components/MovieCard/MovieCard";
import React, {useEffect, useState} from "react";
import axios from "axios";

export default function Favorites() {

    const [favoriteMovies, setFavoriteMovies] = useState<Movie[]>([]);
    useEffect(() => {
        (async () => {
            const res = await axios.get("/api/movies/favorites");
            setFavoriteMovies(res.data);
        })();
    })


    return (
        <>
            <div className={"gallery"}>
                {favoriteMovies.length === 0 ? <p>Keine Favoriten vorhanden...</p> :
                    favoriteMovies.map(movie => {
                        return <MovieCard key={movie.id} movie={movie}/>
                    })}
            </div>
        </>
    )
}