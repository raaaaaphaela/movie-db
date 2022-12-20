import React from "react";
import axios from "axios";

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
            <p>{title} ({year})</p>
            <button onClick={deleteMovie} className={"btn btn-grey"}>Löschen</button>
        </div>
    )
}