import React, { Component } from "react";
export default class Login extends Component {
    render() {
        return (
            <form>
                <h3>Sign In</h3>
                <div className="mb-3">
                    <label>Username</label>
                    <input
                    type="username"
                    className="form-control"
                    placeholder="Enter username"
                    />
                </div>
                <div className="mb-3">
                    <label>Password</label>
                    <input
                    type="password"
                    className="form-control"
                    placeHolder="Enter password"
                    />
                </div>
                <div className="mb-3">
                    <div className="custom-control custom-checkbox">
                        <input
                        type="checkbox"
                        className="custom-control-input"
                        id="customCheck1"
                        />
                        <label className="custom-control-label" htmlFor="customCheck1">
                            Remember me
                        </label>
                    </div>
                </div>
                <div className="d-grid">
                    <button type="submit" className="btn btn-primary">
                        Submit
                    </button>
                </div>
                <p className="forgot-password text-right">
                    Forgot <a href="/register">password?</a>
                </p>
            </form>
        );
    }
}