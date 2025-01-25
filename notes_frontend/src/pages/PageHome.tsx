export default function PageHome() {

    const notes = [
        {
            noteId: 1,
            authorId: 101,
            title: "Test Title",
            content: "Content This is the content. I have to do lots of works",

        },
        {
            noteId: 2,
            authorId: 101,
            title: "Test Title",
            content: "Content This is the content. I have to do lots of works",

        },
        {
            noteId: 3,
            authorId: 101,
            title: "Test Title",
            content: "Content This is the content. I have to do lots of works",

        },
        {
            noteId: 4,
            authorId: 104,
            title: "Test Title",
            content: "Content This is the content. I have to do lots of works",

        },
        {
            noteId: 5,
            authorId: 104,
            title: "Test Title",
            content: "Content This is the content. I have to do lots of works Content  aasfasdf asdf asd fa sdf asdf asd f sdf This is the content. I have to do lots of works Content This is the content. I have to do lots of works Content This is the content. I have to do lots of works Content This is the content. I have to do lots of works Content This is the content. I have to do lots of works",

        },
        {
            noteId: 6,
            authorId: 104,
            title: "Test Title",
            content: "Content This is the content. I have to do lots of works",

        },
        {
            noteId: 7,
            authorId: 104,
            title: "Test Title",
            content: "Content This is the content. I have to do lots of works",

        },
    ]
    const topAuthors = [
        {
            authorId: 101,
            authorName: "nanasfi. sdf",
        },
        {
            authorId: 102,
            authorName: "sdrrr. sdf",
        },
        {
            authorId: 103,
            authorName: "saddam. sdf",
        },
        {
            authorId: 104,
            authorName: "uzbek. sdf",
        },
    ]
    const topNotes = [
        {
            noteId: 3,
            authorId: 101,
            title: "Test Title",
            content: "Content This is the content. I have to do lots of works",

        },
        {
            noteId: 4,
            authorId: 104,
            title: "Test Title",
            content: "Content This is the content. I have to do lots of works",

        },
        {
            noteId: 5,
            authorId: 104,
            title: "Test Title",
            content: "Content This is the content. I have to do lots of works Content  aasfasdf asdf asd fa sdf asdf asd f sdf This is the content. I have to do lots of works Content This is the content. I have to do lots of works Content This is the content. I have to do lots of works Content This is the content. I have to do lots of works Content This is the content. I have to do lots of works",

        },
    ]

    return (
        <div className="mt-14">

            <div className="grid grid-cols-12 gap-5">

                <div className="col-span-10 p-2 overflow-y-auto h-screen no-scrollbar">
                    {notes.map((item) => (
                        <div key={item.noteId} className="group hover:cursor-pointer mt-5">
                            <div className="flex flex-col  mx-4">
                                <h2 className="hover:underline hover:cursor-pointer  font-normal font-mono p-2 text-sm">
                                    singh0097
                                </h2>

                                <h1 className="text-5xl font-semibold font-serif py-3">
                                    {item.title}
                                </h1>
                                <div
                                    className="text-lg font-normal font-serif pe-5 overflow-hidden text-ellipsis whitespace-nowrap">
                                    {item.content}
                                </div>


                            </div>
                            <div className="flex justify-end ">
                                <h2 className="mx-3">Fav</h2>
                                <h2 className="mx-3">views 332</h2>
                            </div>
                            <div className="h-px bg-gray-300 block group-hover:bg-black"></div>
                        </div>
                    ))}
                </div>
                <div className="col-span-2  p-2 overflow-y-auto top-0 h-screen">

                    <h2 className="font-semibold font-serif text-xl mt-10">Top Authors</h2>
                    {topAuthors.map((author) => (
                        <div key={author.authorId} className="flex">
                            <h2 className="font-normal font-serif text-lg">{author.authorName}</h2>
                        </div>
                    ))}

                    <h2 className="font-semibold font-serif text-xl mt-10">Top Notes</h2>

                    {topNotes.map((note,) => (
                        <li key={note.noteId} className="flex">
                            <h2 className="font-normal font-serif text-lg ">{note.title}</h2>
                        </li>
                    ))}


                </div>

            </div>

        </div>
    )
}