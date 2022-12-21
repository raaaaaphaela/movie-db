import React from "react";
import axios from "axios";
import MovieDetails from "./MovieDetails/MovieDetails";

export default function MovieCard({id, imageUrl, title, year}: {
    id: number,
    imageUrl: string,
    title: string,
    year: number
}) {

    async function deleteMovie() {
        try {
            await axios.delete("/api/movies/" + id);
            window.location.reload();

        } catch (e) {
            console.log(e)
        }
    }

    return (
        <div className={"movie-card"}>
            <img src={imageUrl} alt=""/>
            <p>{title}</p>
            <button onClick={deleteMovie} className={"btn btn-grey"}>Löschen</button>
            <MovieDetails id={id} title={title} imageUrl={imageUrl} year={year}/>
        </div>
    )
}