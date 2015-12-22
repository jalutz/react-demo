module.exports = {
    context: __dirname,
    entry: './app.js',
    output: {
        filename: "bundle.js",
        path: __dirname + "/dist"
    },
    module: {
        loaders: [
            {
                test: /\.js$/,
                exclude: /node_modules/,
                loaders: ["babel-loader?presets[]=react,presets[]=es2015"]
            },
            {
                test: /\.jsx$/,
                loaders: ['babel-loader?presets[]=react,presets[]=es2015']
            }
        ]
    },
    resolve: {
        extensions: ['', '.js', '.jsx']
    },
    watch: true
};