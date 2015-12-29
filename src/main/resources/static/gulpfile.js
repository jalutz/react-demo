var gulp = require('gulp');
var browserify = require('browserify');
var babelify = require('babelify');
var source = require('vinyl-source-stream');
var minify = require('gulp-minify');

gulp.task('watch', function () {
    gulp.watch('*.jsx', ['compress']);
});

gulp.task('build', ['watch'], function () {
    return browserify({entries: './app.jsx', extensions: ['.jsx'], debug: true})
        .transform(babelify, {presets: ["es2015", "react"]})
        .bundle()
        .pipe(source('bundle.js'))
        .pipe(gulp.dest('dist'));
});

gulp.task('compress', ['build'], function(){
    gulp.src('dist/bundle.js')
        .pipe(minify({
            ignoreFiles: ['-min.js']
        }))
        .pipe(gulp.dest('dist'))
})

gulp.task('default', ['compress']);