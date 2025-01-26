import {useParams} from "react-router-dom";
import {Container, SingleNote} from "../components";
import {TNote} from "../types";

type TParams = {
    noteId: string,
}

function randomString(length: number = 50000): string {
    const data = 'ABC DEF GHI JKL MNO PQR STU VWX YZ abc def ghi jkl mno pqr stu vwx yz';
    let result = '';

    for (let i = 0; i < length; i++) {
        const randomIndex = Math.floor(Math.random() * data.length);
        result += data[randomIndex];
    }

    return result;
}

export default function NotePage(){

    const { noteId } = useParams<TParams>()
    const note : TNote = {
        id : "120",
        title : randomString(100),
        content : `This is Content additional content ${randomString()}`,
        authorId: "12204",
        authorName : randomString(10),
    }
    console.log(noteId)

    return (
        <Container className="p-3 mt-14">
            <SingleNote note={note}/>
        </Container>
    );
}