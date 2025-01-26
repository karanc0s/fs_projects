import {Container, TextInput} from "../components";
import {useForm} from "react-hook-form";
import {useRef} from "react";
import {useNavigate} from "react-router-dom";


type TFormValues = {
    title: string,
    content: string,
}
export default function WriteNotePage() {

    const navigate = useNavigate();
    const btnRef = useRef<HTMLButtonElement>(null);
    const {register , handleSubmit , setValue, watch} = useForm<TFormValues>()
    const title = watch("title")
    const content = watch("content")

    const triggerSubmit = () => {
        if (btnRef.current) {
            btnRef.current.click();
        }
    };
    const submit = (values: TFormValues) => {
        console.log(values)
    }

    return (
        <div>
            <header className="px-6 flex justify-between max-w-7xl text-center mx-auto">
                <div
                    className="py-3 hover:cursor-pointer text-xl font-semibold font-mono "
                    onClick={() => {navigate("/")}}
                >Notes</div>

                <button
                    disabled={!title || !content}
                    onClick={triggerSubmit}
                    className={`inline-block duration-200
                        font-mono text-xl rounded-sm px-8 py-3 
                        disabled:line-through
                        ${(!title || !content) ? "disabled:line-through disabled:cursor-not-allowed" : " hover:bg-black hover:text-white"}
                       
                        `}
                >
                    Submit
                </button>

            </header>
            <Container className="flex flex-col max-w-5xl mx-auto mt-10">
                <form onSubmit={handleSubmit(submit)}>
                    <TextInput
                        placeholder="A Nice Title"
                        {...register("title")}
                    />

                    <div
                        id="editableDiv"
                        contentEditable={true}
                        {...register("content")}
                        onInput={(e) => setValue("content", e.currentTarget.textContent || "")}
                        className="mt-3 py-2 text-xl font-serif border-b focus:border-black duration-200 focus:outline-0 w-full"
                    >
                    </div>
                    <button
                        ref={btnRef}
                        type="submit"
                        className="hidden"
                    >
                        Hidden Submit
                    </button>
                </form>


            </Container>
        </div>

    )
}