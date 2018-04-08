"use strict";

Object.defineProperty(exports, "__esModule", {
    value: true
});
exports.default = setDescription;
function setDescription(description) {
    return description.replace(/\r\n|\r|\n/g, "\\n").replace(/;/g, "\\;").replace(/:/g, "\\:");
}