import {TUser} from "./TUser.ts";

export type TAuthState = {
    status: boolean,
    userData: TUser | null,
}