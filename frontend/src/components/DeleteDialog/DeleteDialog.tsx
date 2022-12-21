import React, {useState} from "react";
import axios from "axios";

export default function DeleteDialog ({id, title}: {
    id: number,
    title: string
}) {
    const [modal, setModal] = useState<boolean>(false);

    const toggleModal = () => {
        setModal(!modal);
    }

    async function deleteMovie() {
        try {
            await axios.delete("/api/movies/" + id);
            window.location.reload();

        } catch (e) {
            console.log(e)
        }
    }

    return (
        <>
            <button onClick={toggleModal}
                    className={"btn btn-grey"}>
                Löschen
            </button>
            {modal && (
                <div className={"modal"}>
                    <div onClick={toggleModal} className="overlay"></div>
                    <div className="modal-content">
                        <h2>"{title}" wirklich löschen?</h2>
                        <button onClick={deleteMovie} className={"btn btn-grey"}>Löschen</button>
                        <button onClick={toggleModal} className={"modal-close"}>X</button>
                    </div>
                </div>
            )}
        </>
    )
}