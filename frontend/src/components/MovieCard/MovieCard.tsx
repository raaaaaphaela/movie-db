import React, {useState} from "react";
import "./MovieCard.css";
import MovieDetails from "../MovieDetails/MovieDetails";
import DeleteDialog from "../DeleteDialog/DeleteDialog";
import axios from "axios";
import {Movie} from "../../Types";

export default function MovieCard(props: { movie: Movie }) {

    const [currentMovie, setCurrentMovie] = useState<Movie>(props.movie);

    const changeFavStatus = async () => {

        await axios.put("/api/movies", {...currentMovie, favorite: !currentMovie.favorite});
        setCurrentMovie({
            ...currentMovie, favorite: !currentMovie.favorite
        })
    }

    return (
        <div className={"movie-card"}>
            <img src={props.movie.imageUrl} alt=""/>
            <div>
                <p>{props.movie.title}</p>
                <div className={"movie-card-controls"}>
                    <DeleteDialog id={props.movie.id} title={props.movie.title}/>
                    <MovieDetails id={props.movie.id} title={props.movie.title} imageUrl={props.movie.imageUrl}
                                  year={props.movie.year}/>
                    <div className={currentMovie.favorite ? "favorite is-fav": "favorite"} onClick={() => changeFavStatus()}>{currentMovie.favorite ? <p>&#9829;</p> : <p>&#9825;</p>}</div>
                </div>
            </div>
        </div>
    )
}