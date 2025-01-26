import {Outlet} from "react-router-dom";

export default function WriteNoteLayout() {
    return (
        <main className="block">
            <Outlet />
        </main>
    );
}