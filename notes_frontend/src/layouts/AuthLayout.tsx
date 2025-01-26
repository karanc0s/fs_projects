import {Outlet} from "react-router-dom";

export default function AuthLayout() {
    return (
        <div className="h-screen w-screen bg-amber-100">
            <main>
                <Outlet />
            </main>
        </div>
    )
}