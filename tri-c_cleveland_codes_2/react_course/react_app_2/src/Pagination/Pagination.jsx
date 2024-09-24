import { usePagination, DOTS } from './usePagination'
import './pagination.css'

export default function Pagination(props) {
    const {onPageChange, totalCount, siblingCount = 1, currentPage, pageSize, className} = props

    const paginationRange = usePagination({
        currentPage, totalCount, siblingCount, pageSize
    })

    // If there are less than 2 times in pagination range we shall not render the component
    if (currentPage === 0 || paginationRange.length < 2) {
        return null;
    }

    const onNext = () => {
        onPageChange(currentPage + 1);
    }

    const onPrevious = () => {
        onPageChange(currentPage - 1);
    }

    let lastPage = paginationRange[paginationRange.length - 1]

    return (
        <ul className={`${className} pagination-container`}>
            {/* left navigation arrow */}
            <li className={currentPage === 1 ? "pagination-item disabled" : "pagination-item"} onClick={onPrevious}>
                <div className="arrow left"></div>
            </li>
            {/* if the pageItem is a DOT, render the DOTS unicode char */}
            {paginationRange.map(pageNumber => {
                if (pageNumber === DOTS) {
                    return (<li key={crypto.randomUUID()} className="pagination-item dots">&#8230;</li>);
                }

                // render our page pills
                return (
                    <li key={pageNumber} className={pageNumber === currentPage ? `pagination-item selected` : `pagination-item`} onClick={() => onPageChange(pageNumber)}>
                        {pageNumber}
                    </li>
                )
            })}
            {/* rigth navigation arrow */}
            <li className={currentPage === lastPage ? "disabled pagination-item" : "pagination-item"} onClick={onNext}>
                <div className="arrow right"></div>
            </li>

        </ul>
    );
}