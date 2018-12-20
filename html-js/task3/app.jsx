class Nav extends React.Component {
    render() {
        return (
            <nav>
                <div class="block">
                    <p>Navigation</p>
                </div>
            </nav>
        );
    }
}
class Main extends React.Component {
    render() {
        return (
            <main>
                <div class="block">
                    <div id="main-content"></div>
                </div>
            </main>
        );
    }
}
class MainContent extends React.Component {
    render() {
        return ([
            <div id="coubs"></div>,
            <div id="text"></div>]
        );
    }
}

class Text extends React.Component {
    render() {
        return (<p>Text</p>

            );
    }
}

class Header extends React.Component {
    render() {
        return (
            <header>
                <div class="block">
                    <p>Header</p>
                </div>
            </header>
        );
    }
}

class Footer extends React.Component {
    render() {
        return (
            <footer>
                <div class="block">
                    <p class="up">Footer</p>
                    <div id="row"></div>
                </div>
            </footer>
        );
    }
}

class App extends React.Component {
    render() {
        return [
            <div id="header"></div>,
            <div id="nav"></div>,
            <div id="main"></div>,
            <div id="footer"></div>
        ];
    }
}

class Coubs extends React.Component {
    render() {
        return (
            <div class="center">
                <div id="coub"></div>
                <div id="coub"></div>
                <div id="coub"></div>
                <div id="coub"></div>
            </div>
        );
    }
}

ReactDOM.render(<App />, document.getElementById('app'));
ReactDOM.render(<Header />, document.getElementById('header'));
ReactDOM.render(<Nav />, document.getElementById('nav'));
ReactDOM.render(<Main />, document.getElementById('main'));
ReactDOM.render(<MainContent />, document.getElementById('main-content'));
ReactDOM.render(<Coubs />, document.getElementById('coubs'));
ReactDOM.render(<Text />, document.getElementById('text'));
ReactDOM.render(<Footer />, document.getElementById('footer'));