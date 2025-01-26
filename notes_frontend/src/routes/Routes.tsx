import {createBrowserRouter, createRoutesFromElements, Route} from "react-router-dom";
import App from "../App.tsx";
import {HomePage, NotePage, WriteNotePage} from "../pages";
import {AuthLayout, WriteNoteLayout} from "../layouts";

const routes = createBrowserRouter(
    createRoutesFromElements(
        <>
            <Route path="/" element={<App/>}>
                <Route path="/" element={<HomePage/>}/>
                <Route path="/note/:noteId" element={<NotePage/>}/>
                <Route path="/write" element={<WriteNotePage />}/>
            </Route>
            <Route path="/write" element={<WriteNoteLayout />}>
                <Route index element={<WriteNotePage />} />
            </Route>
            <Route path="/auth" element={<AuthLayout />} >

            </Route>
        </>
    )
)
export default routes