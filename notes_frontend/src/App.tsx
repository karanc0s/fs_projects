import {Outlet} from "react-router-dom";
import {Footer, Header} from "./components";

function App() {

    return (
        <>
            <Header />
            <main className="block">
                <Outlet/>
            </main>
            <Footer/>
        </>
    )
}

export default App
