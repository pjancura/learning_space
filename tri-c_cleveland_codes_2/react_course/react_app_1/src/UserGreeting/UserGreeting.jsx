import PropTypes from 'prop-types';

export function UserGreeting (props) {
    const welcomeMessage =  <h2 className="welcome-message">
                                Welcome {props.userName}
                                </h2>
    const loginPrompt = <h2 className="login-prompt">
                            Please Log in
                            </h2>

    return(props.isLoggedIn ? welcomeMessage : loginPrompt);
                                

}

UserGreeting.proptypes = {
    isLoggedIn: PropTypes.bool,
    userName: PropTypes.string,
}

UserGreeting.defaultProps = {
    isLoggedIn: false,
    userName: "Guest"
}