import {createSlice, PayloadAction} from "@reduxjs/toolkit";
import {TAuthState, TUser} from "../types";

const initialState: TAuthState = {
    status: false,
    userData: null,
}

const logIn = (state : TAuthState , action: PayloadAction<TUser>)=>{
    state.status = true;
    state.userData = action.payload;
}
const logOut = (state : TAuthState)=>{
    state.status = false
    state.userData = null
}
const getCurrentUser = () :void =>{}

const authSlice = createSlice({
    name: "Auth_Slice",
    initialState: initialState,
    reducers: {
        logIn,
        logOut,
        getCurrentUser,
    }
})

export const AuthActions = authSlice.actions;
export const AuthReducer = authSlice.reducer;