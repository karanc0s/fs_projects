import {TNote} from "../types";
import {useState} from "react";
import {Container} from "./index.ts";

interface Props{
    note : TNote
}

export default function SingleNote(props : Props){
    const {note} = props;
    console.log(note);
    const [likes, setLikes] = useState(101);
    const [isFavorite, setIsFavorite] = useState(false);

    const handleLike = () => {
        setLikes(likes + 1);
    };

    const toggleFavorite = () => {
        setIsFavorite(!isFavorite);
    };

    return (
        <Container className="flex flex-col max-w-4xl mx-auto p-4 mt-5">
            <h1 className="text-3xl font-bold mb-2 font-mono">{note.title}</h1>
            <hr className="my-4"/>
            <div className="flex justify-between items-center mb-2">
                <div className="flex">
                    <button onClick={handleLike} className="flex items-center space-x-2 ">
                        <span className="text-xl">{likes}</span>
                        <span className="text-sm">Likes</span>
                    </button>

                    <button onClick={toggleFavorite} className="flex items-center space-x-2 mx-3">
                        <span className="text-sm">{isFavorite ? 'Unfavorite' : 'Favorite'}</span>
                    </button>
                </div>
                <div
                    className="hover:underline hover:cursor-pointer text-xl mx-4 font-serif font-extralight"
                    onClick={()=>{}}
                >
                    {note.authorName}
                </div>

            </div>
            <hr className="my-4"/>

            <div className="text-lg leading-relaxed font-serif  min-h-screen">
                {note.content}
            </div>
        </Container>
    )
}