import React, {useState} from "react";
import "./NewMovie.css";
import axios from "axios";
import {PostMovie} from "../../Types";

export default function NewMovie() {

    const [newMovie, setNewMovie] = useState<PostMovie>({title: "", imageUrl: "", year: 0, favorite: false});

    function onChange(e: React.ChangeEvent<HTMLInputElement>) {
        const targetValue: string = e.target.value;
        const targetName: string = e.target.name;

        setNewMovie({...newMovie, [targetName]: targetValue});
    }

    async function onSubmit() {
        await axios.post("/api/movies", newMovie);
    }

    return (
        <form className={"movie-form"} onSubmit={onSubmit}>
            <h3>Neuen Film hinzufügen</h3>
            <div className={"movie-form-input"}>
                <label htmlFor={"title"}>Titel: </label>
                <input id={"title"}
                       type="text"
                       name={"title"}
                       value={newMovie.title}
                       onChange={onChange}
                       required={true}/>
            </div>
            <div className={"movie-form-input"}>
                <label htmlFor={"image"}>Bild: </label>
                <input id={"image"}
                       type="text"
                       name={"imageUrl"}
                       value={newMovie.imageUrl}
                       onChange={onChange}
                       required={true}/>
            </div>
            <div className={"movie-form-input"}>
                <label htmlFor={"year"}>Jahr: </label>
                <input id={"year"}
                       type="number"
                       name={"year"}
                       value={newMovie.year}
                       onChange={onChange}
                       required={true}/>
            </div>
            <button type={"submit"} className={"btn btn-blue"}>Hinzufügen</button>
        </form>
    )
}