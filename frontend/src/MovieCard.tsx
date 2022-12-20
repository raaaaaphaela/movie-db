import React from "react";

export default function MovieCard({imageUrl, title, year}: {
    imageUrl: string,
    title: string,
    year: number
}) {
    return (
        <div className={"movie-card"}>
            <img src={imageUrl} alt=""/>
            <p>{title} ({year})</p>
        </div>
    )
}