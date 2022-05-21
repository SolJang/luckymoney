"use strict";

import axios from "axios";

function getObjectToURLSearchParams(object) {
    const keys = Object.keys(object);
    if (keys.length > 0) {
        let returnObject = new URLSearchParams();
        keys.forEach(el => {
            returnObject.append(el, object[el]);
        });
        return returnObject;
    }
    return null;
}

const jsonConfig = {
    timeout: 30000,
    headers: { "Content-Type": "application/json" }
};

const postConfig = {
    timeout: 30000,
    headers: { "Content-Type": "application/x-www-form-urlencoded; charset=UTF-8" }
};

export const getAxios = async (url, params) => {
    try {
        const res = await axios({
            method: "get",
            url,
            ...jsonConfig,
            params: params,
            data: {}
        });
        return res.data;
    } catch (error) {
        console.error(error);
        return null;
    }
};

export const postAxios = async (url, params) => {
    params = typeof params === "object" ? getObjectToURLSearchParams(params) : params;
    try {
        const res = await axios({
            method: "post",
            url,
            ...postConfig,
            // params: params,
            data: params
        });
        return res.data;
    } catch (error) {
        console.error(error);
        return null;
    }
};

export const postAxiosJsonHeader = async (url, params) => {
    try {
        const res = await axios({
            method: "post",
            url,
            jsonConfig,
            data: params
        });
        return res.data;
    } catch (error) {
        console.error(error);
        return null;
    }
};

export const getAxiosWithMessage = async (url, params, successCallback, errorCallback, finallyCallback) => {
    await axios({
        method: "get",
        url,
        jsonConfig,
        params: params,
        data: {}
    })
        .then(res => successCallback(res.data))
        .catch(error => {
            if (error.response) {
                errorCallback(error.response);
            }
        })
        .finally(() => {
            if (finallyCallback) finallyCallback();
        });
};

export const postAxiosWithMessage = async (url, params, successCallback, errorCallback) => {
    params = typeof params === "object" ? getObjectToURLSearchParams(params) : params;
    await axios({
        method: "post",
        url,
        postConfig,
        data: params
    })
        .then(res => successCallback(res.data))
        .catch(error => errorCallback(error.response));
};

export const postAxiosJsonWithMessage = async (url, params, successCallback, errorCallback) => {
    await axios({
        method: "post",
        url,
        jsonConfig,
        data: params
    })
        .then(res => successCallback(res.data))
        .catch(error => errorCallback(error.response));
};

export const formSubmit = (url, params) => {
    let form = document.createElement("form");
    let input = [];
    form.action = url;
    form.method = "POST";
    // form.target = "blank";

    let i = 0;
    for (let key in params) {
        if (params[key] !== undefined && params[key] !== null && params[key] !== "") {
            input[i] = document.createElement("input");
            input[i].setAttribute("type", "hidden");
            input[i].setAttribute("name", key);
            input[i].setAttribute("value", params[key]);
            form.appendChild(input[i]);
        }
        i++;
    }

    document.body.appendChild(form);
    form.submit();
};

export const deleteAxiosWithMessage = async (url, params, successCallback, errorCallback) => {
    await axios({
        method: "delete",
        url,
        ...postConfig,
        params: params,
        data: params
    })
        .then(res => successCallback(res.data))
        .catch(error => {
            if (error.response) {
                errorCallback(error.response);
            }
        });
}