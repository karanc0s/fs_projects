import {Container} from "./index.ts";
import React from "react";

export default function Header(){
    const [auth, setAuth] = React.useState(true)

    const navItem=[

        {
            name : "Home",
            path : "/",
            active : auth
        },
        {
            name : "Login",
            path : "/",
            active : auth
        },
        {
            name : "Signup",
            path : "/",
            active : auth
        },
        {
            name : "My Notes",
            path : "/",
            active : auth
        },
    ];



    return (
        <header className="flex">
            <Container>
                <nav className="px-3 flex items-center justify-evenly">
                    <div className="mx-auto py-3 hover:cursor-pointer">
                        <h1 className="text-xl"> Notes App </h1>
                    </div>
                    <ul className="flex ml-auto">
                        {navItem.map(
                            (item) => item.active ? (
                                <li key={item.name}>
                                    <button
                                        className="inline-block duration-200
                                        hover:bg-black hover:text-white
                                        text-xl
                                        rounded-sm px-7 py-3"
                                    >
                                        {item.name}
                                    </button>
                                </li>
                            ) : null
                        )}
                    </ul>
                    {auth ? <div className="ml-3 mr-10 relative group">
                        <button
                            className="w-10 h-10 rounded-full bg-gray-500 flex items-center justify-center"
                        >
                            P
                        </button>
                        <div
                            className="absolute -right-5 mt-2 w-48 bg-white border rounded shadow-lg opacity-0 group-hover:opacity-100 transition-opacity duration-200">

                                <button className="block w-full text-center px-3 py-2 hover:bg-gray-200">
                                    Details
                                </button>

                                <button className="block w-full text-center px-3 py-2 hover:bg-gray-200">
                                    Logout
                                </button>

                        </div>
                    </div> : null}
                </nav>
                <div className="h-0.5 bg-black block"></div>
            </Container>
        </header>
    );
}