import React from "react";
import "./MovieCard.css";
import MovieDetails from "../MovieDetails/MovieDetails";
import DeleteDialog from "../DeleteDialog/DeleteDialog";

export default function MovieCard({id, imageUrl, title, year}: {
    id: number,
    imageUrl: string,
    title: string,
    year: number
}) {

    return (
        <div className={"movie-card"}>
            <img src={imageUrl} alt=""/>
            <p>{title}</p>
            <DeleteDialog id={id} title={title}/>
            <MovieDetails id={id} title={title} imageUrl={imageUrl} year={year}/>
        </div>
    )
}