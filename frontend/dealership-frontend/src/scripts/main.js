
document.addEventListener("DOMContentLoaded", () => {

    const slides = document.querySelectorAll('.slide');
    const prev = document.querySelector('.prev');
    const next = document.querySelector('.next');
    const navigationButtons = document.querySelectorAll('.navigation button');
    
    let currentSlide = 0;
    
    // Hide all slides except the first one
    slides.forEach((slide, index) => {
      if (index !== 0) {
        slide.style.display = 'none';
      }
    });
    
    // Go to the next slide
    function nextSlide() {
      slides[currentSlide].style.display = 'none';
      currentSlide = (currentSlide + 1) % slides.length;
      slides[currentSlide].style.display = 'flex';
      updateNavigationButtons();
    }
    
    // Go to the previous
    function prevSlide() {
        slides[currentSlide].style.display = 'none';
        currentSlide = (currentSlide - 1 + slides.length) % slides.length;
        slides[currentSlide].style.display = 'flex';
        updateNavigationButtons();
        }
        
        // Update navigation buttons
        function updateNavigationButtons() {
        navigationButtons.forEach((button, index) => {
        if (index === currentSlide) {
        button.classList.add('active');
        } else {
        button.classList.remove('active');
        }
        });
        }
        
        // Add event listeners to navigation buttons
        prev.addEventListener('click', prevSlide);
        next.addEventListener('click', nextSlide);
        
        // Make slider responsive
        window.addEventListener('resize', () => {
        if (window.innerWidth < 800) {
        slides.forEach(slide => slide.style.width = window.innerWidth + 'px');
        } else {
        slides.forEach(slide => slide.style.width = '100%');
        }
        });
        
        // Update navigation buttons when the slider loads
        updateNavigationButtons();    
})