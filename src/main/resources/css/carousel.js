console.log('Hello');
const track = document.querySelector('.carousel_track');
const slides = Array.from(track.children);
const nextButton = document.querySelector('.carousel_button--right');
const prevButton = document.querySelector('.carousel_button--left');
const dotNav = document.querySelector('.carousel_nav');
const dots = Array.from(dotNav.children);


const slideSize = slides[0].getBoundingClientRect();
const slideWidth = slideSize.width;

console.log(slideSize);



// Functions 

const setSlidePosition = (slide, index) => {
    slide.style.left = slideWidth * index + 'px';
};

const moveToSlide = (track, currentSlide, targetSlide) => {
    track.style.transform = 'translateX(-' + targetSlide.style.left+ ')';
    currentSlide.classList.remove('current-slide');
    targetSlide.classList.add('current-slide');

    console.log(track);
}

const updateDots = (currentDot, targetDot) => {
    currentDot.classList.remove('current-slide');
    targetDot.classList.add('current-slide');
}

const hideShowButtons = (slides, prevButton, nextButton, targetIndex) => {
    if (targetIndex === 0) {
        prevButton.classList.add('is--hidden')
        nextButton.classList.remove('is--hidden');
    } else if (targetIndex === 2) {
        prevButton.classList.remove('is--hidden');
        nextButton.classList.add('is--hidden');
    } else {
        prevButton.classList.remove('is--hidden');
        nextButton.classList.remove('is--hidden');
    }
}

slides.forEach(setSlidePosition);





// making the next button work    

nextButton.addEventListener('click', e => {
    const currentSlide = track.querySelector('.current-slide');
    const nextSlide = currentSlide.nextElementSibling;
    const currentDot = dotNav.querySelector('.current-slide');
    const nextDot = currentDot.nextElementSibling;
    const nextIndex = slides.findIndex(slide => slide === nextSlide)
  

    
    moveToSlide(track, currentSlide, nextSlide);
    updateDots(currentDot, nextDot);
    hideShowButtons(slides, prevButton, nextButton, nextIndex);

})

// making the back button work   

prevButton.addEventListener('click', e => {
    const currentSlide = track.querySelector('.current-slide');
    const prevSlide = currentSlide.previousElementSibling;
    const currentDot = dotNav.querySelector('.current-slide');
    const prevDot = currentDot.previousElementSibling;
    const prevIndex = slides.findIndex(slide => slide === prevSlide);
    

    moveToSlide(track, currentSlide, prevSlide);
    updateDots(currentDot, prevDot);
    hideShowButtons(slides, prevButton, nextButton, prevIndex);
   
})


// making the buttons at the bottom work

dotNav.addEventListener('click', e => {
    const targetDot = e.target.closest('button');

    if(!targetDot) return;

    const currentSlide = track.querySelector('.current-slide');
    const currentDot = dotNav.querySelector('.current-slide');
    const targetIndex = dots.findIndex(dot => dot === targetDot);
    const targetSlide = slides[targetIndex];

    moveToSlide(track, currentSlide, targetSlide);
    updateDots(currentDot, targetDot);

    // This makes the buttons dissappear at the start and at the end
    console.log(targetIndex);
    hideShowButtons(slides, prevButton, nextButton, targetIndex);
    
   
})

