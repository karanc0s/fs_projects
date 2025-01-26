import React, {HTMLProps, Ref, useId} from "react";

interface Props extends HTMLProps<HTMLInputElement>{
    label?: string;
    placeholder?: string;
}

export const TextInput = React.forwardRef((
    props: Props,
    ref: Ref<HTMLInputElement>,
)=>{

    const {placeholder, type ,label, ...restOfProps} = props
    const id = useId();

    return (
        <div className="w-full">
            {label && <label className="inline-block mb-1 pl-1" htmlFor={id}>{label}</label>}
            <input
                type={type}
                placeholder={placeholder}
                className={`py-2 text-5xl font-serif border-b focus:border-black duration-200 focus:outline-0 w-full ${props.className}`}
                ref={ref}
                {...restOfProps}
                id={id}
            />
        </div>
    )
});