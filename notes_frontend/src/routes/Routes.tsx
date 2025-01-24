import {createBrowserRouter, createRoutesFromElements, Route} from "react-router-dom";
import App from "../App.tsx";
import {PageHome} from "../pages";

const routes = createBrowserRouter(
    createRoutesFromElements(
        <Route path="/" element={<App />} >

            <Route path="/" element={<PageHome />} />

        </Route>
    )
)
export default routes