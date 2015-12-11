///<reference path="../../bower_components/polymer-ts/polymer-ts.d.ts"/>
var __extends = (this && this.__extends) || function (d, b) {
    for (var p in b) if (b.hasOwnProperty(p)) d[p] = b[p];
    function __() { this.constructor = d; }
    d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
};
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var HolidayHackingApp = (function (_super) {
    __extends(HolidayHackingApp, _super);
    function HolidayHackingApp() {
        _super.apply(this, arguments);
    }
    HolidayHackingApp.prototype.toggleObserver = function () {
        if (this.toggle)
            this.sendRequest();
    };
    HolidayHackingApp.prototype.sendRequest = function () {
        this.$.ajax.generateRequest();
    };
    HolidayHackingApp.prototype.handleResponse = function (e, response) {
        console.log(response);
    };
    __decorate([
        property({ type: Boolean, value: false })
    ], HolidayHackingApp.prototype, "toggle");
    __decorate([
        observe("toggle")
    ], HolidayHackingApp.prototype, "toggleObserver");
    HolidayHackingApp = __decorate([
        ///<reference path="../../bower_components/polymer-ts/polymer-ts.d.ts"/>
        component("holiday-hacking-app")
    ], HolidayHackingApp);
    return HolidayHackingApp;
})(polymer.Base);
HolidayHackingApp.register();
