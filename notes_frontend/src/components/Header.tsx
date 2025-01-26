import {Container} from "./index.ts";
import {useEffect, useRef, useState} from "react";
import {useNavigate} from "react-router-dom";

export default function Header(){
    const navigate = useNavigate();
    const [auth, setAuth] = useState(false)
    const [dropDown , setDropDown] = useState(false);
    const dropDownRef = useRef<HTMLDivElement>(null);

    const handleClickOutside = (event: MouseEvent) => {
        if (dropDownRef.current && !dropDownRef.current.contains(event.target as Node)) {
            setDropDown(false);
        }
    };

    useEffect(() => {
        document.addEventListener("mousedown", handleClickOutside);
        return () => {
            document.removeEventListener("mousedown", handleClickOutside);
        };
    }, []);

    const navItem=[

        {
            name : "Home",
            path : "/",
            active : auth
        },
        {
            name : "Login",
            path : "/auth",
            active : !auth
        },
        {
            name : "Signup",
            path : "/auth",
            active : !auth
        },
        {
            name : "Write",
            path : "/write",
            active : auth
        },
        {
            name : "My Notes",
            path : "/",
            active : auth
        },
    ];



    return (
        <header className="flex fixed w-full bg-white top-0">
            <Container>
                <nav className="px-3 flex items-center justify-evenly">
                    <div
                        className="flex items-center justify-center flex-1 mx-auto py-3 hover:cursor-pointer text-xl font-semibold font-mono"
                        onClick={()=>{navigate("/")}}
                    >
                         Notes
                    </div>
                    <div className="flex flex-1 items-center justify-evenly">
                        <ul className="flex ml-auto">
                            {navItem.map(
                                (item) => item.active ? (
                                    <li key={item.name}>
                                        <button
                                            className="inline-block duration-200 hover:bg-black hover:text-white font-mono text-xl rounded-sm px-8 py-3"
                                            onClick={()=>{navigate(item.path)}}
                                        >
                                            {item.name}
                                        </button>
                                    </li>
                                ) : null
                            )}
                        </ul>
                        {auth ? <div className="ml-3 mr-10 relative group" ref={dropDownRef}>
                            <button
                                className="w-10 h-10 rounded-full bg-gray-500 flex items-center justify-center"
                                onFocus={() => {
                                    setDropDown(!dropDown)
                                }}

                            >P</button>
                            {dropDown ? <div
                                className="absolute -right-5 mt-2 w-48 bg-white border rounded shadow-lg duration-200"
                            >

                                <button className="block w-full text-center px-3 py-2 hover:bg-gray-200">
                                    Details
                                </button>

                                <button className="block w-full text-center px-3 py-2 hover:bg-gray-200">
                                    Logout
                                </button>

                            </div> : null}

                        </div> : null}
                    </div>

                </nav>
                <div className="h-0.5 bg-black block"></div>
            </Container>
        </header>
    );
}