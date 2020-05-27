"use strict"

const DOMAIN = 'http://localhost:8080'

export async function doQuery(url, opt) {
    return await fetch(DOMAIN + url, opt);
}