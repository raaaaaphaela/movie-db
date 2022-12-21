import React, {useState} from "react";
import './MovieDetails.css';

export default function MovieDetails({id, imageUrl, title, year}: {
    id: number,
    imageUrl: string,
    title: string,
    year: number
}) {
    const [modal, setModal] = useState<boolean>(false);

    const toggleModal = () => {
        setModal(!modal);
    }
    return (
        <>
            <button onClick={toggleModal}
                    className={"btn btn-grey"}>
                Details
            </button>
            {modal && (
                <div className={"modal"}>
                    <div onClick={toggleModal} className="overlay"></div>
                    <div className="modal-content">
                        <h2>{title}</h2>
                        <p>Erscheinungsjahr: {year}</p>
                        <button onClick={toggleModal} className={"modal-close"}>X</button>
                    </div>
                </div>
            )}
        </>
    )
}