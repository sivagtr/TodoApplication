import axios from "axios"
import { ALL_TASK_API, DEV_HOST, DEV_PORT, TASK_API, VERSION_API } from "../constants/Constants";

export const getAllTasks = async () => {
    return await axios.get(DEV_HOST + DEV_PORT + VERSION_API + ALL_TASK_API)
        .then(function (response) {
            // handle success
            // console.log(response);
            return response;
        })
        .catch(function (error) {
            // handle error
            // console.log(error);
            return error;
        })
}





export const deleteTaskById = async (id) => {
    return await axios.delete(DEV_HOST + DEV_PORT + VERSION_API + TASK_API + id)
        .then(function (response) {
            // handle success
            // console.log(response);
            return response;
        })
        .catch(function (error) {
            // handle error
            // console.log(error);
            return error;
        })
}