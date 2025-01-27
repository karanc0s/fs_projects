import {configureStore} from "@reduxjs/toolkit";
import {AuthReducer} from "./AuthSlice.ts";

const store = configureStore({
    reducer: {
        authReds : AuthReducer,
    }
});

export default store;

export type StoreState = ReturnType<typeof store.getState>;

export type RootDispatch = typeof store.dispatch;