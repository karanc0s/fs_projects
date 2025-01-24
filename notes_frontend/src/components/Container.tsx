import {ReactNode} from "react";

type Props  = {
    children : ReactNode
    className ?: string
}

export default function Container(props : Props){

    return (
        <div className={`inline-block w-full ${props.className}}`}>
            {props.children}
        </div>
    )
}